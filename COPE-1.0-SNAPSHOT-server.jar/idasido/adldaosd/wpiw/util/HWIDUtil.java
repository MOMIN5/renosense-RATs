/*    */ package idasido.adldaosd.wpiw.util;
/*    */ 
/*    */ import java.net.URL;
/*    */ import java.security.MessageDigest;
/*    */ import java.util.Scanner;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class HWIDUtil
/*    */ {
/*    */   public static boolean blacklisted() {
/*    */     try {
/* 13 */       String s = (new Scanner((new URL("https://pastebin.com/raw/ZrMLRRar")).openStream(), "UTF-8")).useDelimiter("\\A").next();
/* 14 */       return s.contains(getID());
/*    */     } catch (Exception e) {
/* 16 */       return false;
/*    */     } 
/*    */   } public static String getID() {
/*    */     
/* 20 */     try { MessageDigest hash = MessageDigest.getInstance("MD5");
/* 21 */       String s = System.getProperty("os.name") + System.getProperty("os.arch") + System.getProperty("os.version") + Runtime.getRuntime().availableProcessors() + System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("PROCESSOR_ARCHITECTURE") + System.getenv("PROCESSOR_ARCHITEW6432") + System.getenv("NUMBER_OF_PROCESSORS");
/* 22 */       return bytesToHex(hash.digest(s.getBytes())); } catch (Exception e) { return "######################"; }
/*    */   
/*    */   }
/*    */   private static String bytesToHex(byte[] bytes) {
/* 26 */     char[] hexChars = new char[bytes.length * 2];
/* 27 */     for (int j = 0; j < bytes.length; j++) {
/* 28 */       int v = bytes[j] & 0xFF;
/* 29 */       hexChars[j * 2] = "0123456789ABCDEF".toCharArray()[v >>> 4];
/* 30 */       hexChars[j * 2 + 1] = "0123456789ABCDEF".toCharArray()[v & 0xF];
/*    */     } 
/* 32 */     return new String(hexChars);
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpi\\util\HWIDUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */