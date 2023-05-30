package Day_10;

public class BridgeExample2 {
    public static void main(String[] args) {

        FacialRecognition faceRec = new FacialRecognition();
        FingerPrintRecognition fingerRec = new FingerPrintRecognition();

        Employee sarwarSan = new Trainer();
        Employee mehediSan = new Student();

        faceRec.setEmployee(sarwarSan);
        fingerRec.setEmployee(mehediSan);

        faceRec.signIn();
        faceRec.signOut();

        fingerRec.signIn();
        fingerRec.signOut();

        faceRec.setEmployee(mehediSan);
        fingerRec.setEmployee(sarwarSan);

        faceRec.signIn();
        faceRec.signOut();

        fingerRec.signIn();
        fingerRec.signOut();

    }
}
