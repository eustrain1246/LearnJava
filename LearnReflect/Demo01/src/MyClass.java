public class MyClass {
    public String publicField;
    String DefaultField;
    protected String ProtectedField;
    private String PrivateFiled;

    public MyClass() {
    }
    public void setPublicField(String publicField) {
        this.publicField = publicField;
    }

    public String getPublicField() {
        return publicField;
    }
    public void publicMethod(String s){
        System.out.println("publicMethod: " + s);
    }
    void defaultMethod(String s){
        System.out.println("defaultMethod: " + s);
    }
    protected void protectedMethod(String s){
        System.out.println("protectedMethod: " + s);
    }
    private void privateMethod(String s){
        System.out.println("privateMethod: " + s);
    }
    public MyClass(String publicField) {
        this.publicField = publicField;
    }
    private MyClass(String publicField, String privateFiled){
        this.publicField = publicField;
        this.PrivateFiled = privateFiled;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "publicField='" + publicField + '\'' +
                ", DefaultField='" + DefaultField + '\'' +
                ", ProtectedField='" + ProtectedField + '\'' +
                ", PrivateFiled='" + PrivateFiled + '\'' +
                '}';
    }
}