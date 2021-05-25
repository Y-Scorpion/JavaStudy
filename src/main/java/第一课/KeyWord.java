package 第一课;

/**
 * java关键字
 */
public class KeyWord {

        static String []  keyword={"class","extends","implements","interface","import","package"
                ,"break","case","continue","default","do","if","else","for","return","switch",
                "while","false","true","null","boolean","byte","char","short","int","long",
                "float","double","try","catch","throw","throws","finally","abstract","fianl",
                "native","private","protected","public","static","synchronized","transient",
                "volatile","instanceof","new","super","void","assert","enum","goto","const",
                "this",""};
        public static void main(String[] args) {
                for (String keyStr:keyword) {
                        System.out.println(keyStr);
                }
        }
}
