# Pastebin4Java
Paste to pastebin inside of a java application. 

Using Pastebin4Java:<br>
Create new class file (eg: Pastebin.class) in a new package (eg: api.incrementing.pw).<br>
Now paste in the code (https://raw.githubusercontent.com/Incrementing/Pastebin4Java/master/api/incrementing/pw/Pastebin.java).
Now you can do the following to upload to pastebin:
```java
Pastebin paste = new Pastebin("dev key", "user key", Pastebin.Visibility.PUBLIC|UNLISTED|PRIVATE, "format type", "paste name", "paste contents");
paste.makePost();
```
