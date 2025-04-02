package task12;

abstract class Document {
 protected String name;
 protected double size; 

 public Document(String name, double size) {
     this.name = name;
     this.size = size;
 }

 public abstract void open();
 public abstract void save();

 public void getInfo() {
     System.out.println("Document Name: " + name);
     System.out.println("Size: " + size + " KB");
 }
}

class PDFDocument extends Document {
 public PDFDocument(String name, double size) {
     super(name, size);
 }

 @Override
 public void open() {
     System.out.println("Opening PDF file: " + name);
 }

 @Override
 public void save() {
     System.out.println("Saving PDF file: " + name);
 }
}

class TextDocument extends Document {
 public TextDocument(String name, double size) {
     super(name, size);
 }

 @Override
 public void open() {
     System.out.println("Opening Text file: " + name);
 }

 @Override
 public void save() {
     System.out.println("Saving Text file: " + name);
 }
}

class ImageDocument extends Document {
 public ImageDocument(String name, double size) {
     super(name, size);
 }

 @Override
 public void open() {
     System.out.println("Opening Image file: " + name);
 }

 @Override
 public void save() {
     System.out.println("Saving Image file: " + name);
 }
}

public class DocumentManager {
 public static void main(String[] args) {
     Document pdf = new PDFDocument("KaviResume.pdf", 500);
     Document text = new TextDocument("AccountSummery.txt", 50);
     Document image = new ImageDocument("kaviImage.jpg", 2000);

     pdf.getInfo();
     pdf.open();
     pdf.save();
     System.out.println();

     text.getInfo();
     text.open();
     text.save();
     System.out.println();

     image.getInfo();
     image.open();
     image.save();
 }
}
