public class Mood {
    public static void main(String[] args) {
        PsychiatristObject p = new PsychiatristObject();
        HappyObject h = new HappyObject();
        SadObject s = new SadObject();
        p.examine(h);
        System.out.println();
        p.observe(h);
        System.out.println();
        p.examine(s);
        System.out.println();
        p.observe(s);
    }
    static abstract class MoodyObject {
        protected abstract String getMood();

        protected abstract void expressFeelings();

        public void queryMood(String moody) {
            System.out.println("I feel"+getMood()+"today!");
        }
    }

    static class SadObject extends MoodyObject {
        protected String getMood() {
            return "I feel sad today!";
        }

        public void expressFeelings() {
            System.out.println(" 'wah' 'boo hoo' 'weep' 'sob' 'weep' ");
        }

        public String toString() {
            return "Subject cries a lot";
        }
    }

    static class HappyObject extends MoodyObject{
        protected String getMood() {
            return "I feel happy today!";
        }
        public void expressFeelings() {
            System.out.println("hehehe...hahahah...HAHAHAHAHA!!!");
        }
        public String toString() {
            return "Subject laughs a lot";
        }
    }

    static class PsychiatristObject{
        public void examine(MoodyObject moodyObject){
            System.out.println("How are you feeling today?");
            String mood = moodyObject.getMood();
            System.out.println(mood);
        }
        public void observe(MoodyObject moodyObject){
            moodyObject.expressFeelings();
            System.out.println("Observation: " + moodyObject.toString());
        }
    }
}
