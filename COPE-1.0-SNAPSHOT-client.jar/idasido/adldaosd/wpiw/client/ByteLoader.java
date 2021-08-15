/*    */ package idasido.adldaosd.wpiw.client;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class ByteLoader
/*    */   extends ClassLoader {
/*  8 */   public Map<String, byte[]> classes = (Map)new HashMap<>();
/*    */ 
/*    */   
/*    */   protected Class<?> findClass(String s) throws ClassNotFoundException {
/* 12 */     Class<?> clazz = null;
/*    */     try {
/* 14 */       super.findClass(s);
/* 15 */     } catch (Exception exception) {}
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 20 */       if (this.classes.containsKey(s)) {
/* 21 */         clazz = defineClass(s, this.classes.get(s), 0, ((byte[])this.classes.get(s)).length);
/*    */       }
/* 23 */     } catch (Throwable err) {
/* 24 */       err.printStackTrace();
/*    */     } 
/* 26 */     return clazz;
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-client.jar!\idasido\adldaosd\wpiw\client\ByteLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */