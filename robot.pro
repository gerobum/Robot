-injars dist\Robot.jar
-outjars 'H:\Travail\Enseignement\Robot.jar'

-libraryjars 'C:\Program Files\Java\jre6\lib\rt.jar'
-libraryjars 'H:\Travail\Enseignement\xstream-1.2.jar'

-dontskipnonpubliclibraryclasses
-printmapping proguard.map


-keep,allowshrinking class * {
    public static void main(...);
}

# Also keep - Serialization code. Keep all fields and methods that are used for
# serialization.
-keepclassmembers class * extends java.io.Serializable {
    static final long serialVersionUID;
    static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# Also keep - BeanInfo classes. Keep all implementations of java.beans.BeanInfo.
-keep class * extends java.beans.BeanInfo

# Also keep - Bean classes. Keep all specified classes, along with their getters
# and setters.
-keep class * {
    void set*(***);
    void set*(int,***);
    boolean is*();
    boolean is*(int);
    *** get*();
    *** get*(int);
}

# Also keep - Swing UI L&F. Keep all extensions of javax.swing.plaf.ComponentUI,
# along with the special 'createUI' method.
-keep class * extends javax.swing.plaf.ComponentUI {
    public static javax.swing.plaf.ComponentUI createUI(javax.swing.JComponent);
}
