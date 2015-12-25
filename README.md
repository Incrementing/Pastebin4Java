# Pastebin4Java
Paste to pastebin inside of a java application. 

Using Pastebin4Java:<br>
1) Create new class file (eg: Pastebin.java) in a new package (eg: api.incrementing.pw).<br>
2) Paste in the code (https://goo.gl/Z7OpJh).<br>
3) Do the following to upload to pastebin:
```java
Pastebin paste = new Pastebin("dev key", "user key", Pastebin.Visibility.PUBLIC|UNLISTED|PRIVATE, "format type", "paste name", "paste contents");
paste.makePost(); //This can be used a void or a String (eg: System.out.println(paste.makePost()); would print out the url to the paste).
```
