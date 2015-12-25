# Pastebin4Java
Paste to pastebin inside of a java application. 

Using Pastebin4Java:
Create new class file (eg: Pastebin.class) in a new package (eg: api.incrementing.pw).
```java
Pastebin paste = new Pastebin("dev key", "user key", Pastebin.Visibility.PUBLIC|UNLISTED|PRIVATE, "format type", "paste name", "paste contents");
paste.makePost();
```
