/*    */ package idasido.adldaosd.wpiw.util;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public final class Message
/*    */ {
/*    */   private final String name;
/*    */   private final List<Field> fields;
/*    */   
/*    */   private Message(String name, List<Field> fields) {
/* 13 */     this.name = name;
/* 14 */     this.fields = fields;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 19 */     return this.name;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Field> getFields() {
/* 24 */     return this.fields;
/*    */   }
/*    */   
/*    */   public static class Builder
/*    */   {
/*    */     private final String name;
/* 30 */     private final List<Message.Field> fields = new ArrayList<>();
/*    */ 
/*    */     
/*    */     public Builder(String name) {
/* 34 */       this.name = name;
/*    */     }
/*    */ 
/*    */     
/*    */     public Builder addField(String name, String value, boolean inline) {
/* 39 */       this.fields.add(new Message.Field(name, value, inline));
/* 40 */       return this;
/*    */     }
/*    */ 
/*    */     
/*    */     public Message build() {
/* 45 */       return new Message(this.name, this.fields);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public static class Field
/*    */   {
/*    */     private final String name;
/*    */     private final String value;
/*    */     private final boolean inline;
/*    */     
/*    */     public Field(String name, String value, boolean inline) {
/* 57 */       this.name = name;
/* 58 */       this.value = value;
/* 59 */       this.inline = inline;
/*    */     }
/*    */ 
/*    */     
/*    */     public String getName() {
/* 64 */       return this.name;
/*    */     }
/*    */ 
/*    */     
/*    */     public String getValue() {
/* 69 */       return this.value;
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean isInline() {
/* 74 */       return this.inline;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpi\\util\Message.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */