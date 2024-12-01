import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Omatsuri {
    // キーボードからの数字の入力
    public static int inputKey() {
        while(true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = null;
            try {
                str = br.readLine();
            }
             // 入出力処理中の例外処理
            catch (IOException e) {
                System.out.println(e);
            }

             // 数字以外が入力された場合の例外処理
            try {
                return Integer.parseInt(str);
            }
            catch (Exception e) {
                System.out.println("数字以外が入力されました。正しい数字を入力してください。");
                continue;
            }
        }   
    }
    public static void main(String[] args) {
        int ikisaki;
        int syojikin;
        int sagaku;
        boolean buyFlug;
        Human watashi = new Human();
        watashi.okodukai(3000); //財布に2000円を入れる
        System.out.println("今日はお祭りに来ました。");


        while(true) {
            syojikin = watashi.saifu;
            sagaku = watashi.saifu;
            System.out.println("おさいふには" +syojikin+ "円が入っている。");
            System.out.println("「どのお店に行こうかな？」");
             // 屋台の提示とキーボード入力による選択
            System.out.println("行きたいお店の数字を選んで入力後Enter");
            System.out.println("1.たこやき 2.やきそば 3.りんご飴 4.荷物を確認する 0.帰宅");
            ikisaki = inputKey();

         // switch文による屋台の分岐
            switch(ikisaki) {
                case 1:
                    System.out.println("「たこ焼き屋さんに行こう！」");
                    Omise takoyaki = new Omise("たこ焼き屋", "たこ焼き", "１舟８個入り", 600);
                    takoyaki.irassyai();
                    watashi.saifu = takoyaki.buy(syojikin);
                    sagaku = sagaku - watashi.saifu;
                    if(sagaku>0){
                        buyFlug = true;
                        watashi.take("たこ焼き");
                    }
                    break;

                case 2:
                    System.out.println("「焼きそば屋さんに行こう！」");
                    Omise yakisoba = new Omise("焼きそば屋", "焼きそば", "１人前", 500);
                    yakisoba.irassyai();
                    watashi.saifu = yakisoba.buy(syojikin);
                    sagaku = sagaku - watashi.saifu;
                    if(sagaku>0){
                        buyFlug = true;
                        watashi.take("焼きそば");
                    }
                    break;

                case 3:
                    System.out.println("「りんご飴屋さんに行こう！」");
                    Omise ringoame = new Omise("りんご飴屋", "りんご飴", "１本", 400);
                    ringoame.irassyai();
                    watashi.saifu = ringoame.buy(syojikin);
                    sagaku = sagaku - watashi.saifu;
                    if(sagaku>0){
                        buyFlug = true;
                        watashi.take("りんご飴");
                    }
                    break;
                case 4:
                    System.out.println("「荷物の確認をしよう。」");
                    watashi.show();
                    break;
                case 0:
                    System.out.println("「おうちに帰ろう。」プログラムを終了します。");
                    System.exit(0);
                default:
                    System.out.println("正しい数字を入力してください。");
                    System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
                    break;    
            }
        }
    }
}

class Omise {
    String kanban; // 店名
    String item; // 売り物
    String unit; // 単位
    int price; // 値段
    

    Omise(String k, String i, String u, int p){
        kanban = k; // 店名
        item = i; // 売り物
        unit = u; // 単位
        price = p; // 値段
    }

    public void irassyai(){
            System.out.println("ここは" +kanban+ "です。");
    }

    public int buy(int y){
        int kaimono;
        int saifu = y;
        int kakunin;
        while(true) {
            System.out.println(item+ "を" +unit+price+ "円で買いますか？");
            System.out.println("１．買う　２．買わない");
            kaimono = Omatsuri.inputKey();

            switch(kaimono) {
                case 1:
                    kakunin = saifu-price;
                    if (kakunin < 0){
                        System.out.println("お金が足りないので買えません。");
                        break;
                    } else {
                        saifu = kakunin;
                        System.out.println(item+ "を買った！");
                        System.out.println("「ありがとうございました。」");
                        System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
                        return saifu;
                    }

                case 2:
                    System.out.println("やっぱり買うのをやめた。");
                    System.out.println("「また来てくださいね」");
                    System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
                    return saifu;

                default:
                    System.out.println("正しい数字を入力してください。");
                    System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
                    break;    
            }
        }
    }

}

    class Human {
        public int saifu;
        boolean rightHand;
        String rightH;
        boolean leftHand;
        String leftH;
        ArrayList<String> backpack = new ArrayList<>();
        int nimotsu;

        void okodukai(int yen){
            saifu = yen;
        }

        void take(String item) {
            if(rightHand == false) {
                rightHand = true;
                rightH = item;
                System.out.println("右手に" +rightH+ "を持った！");
            } else if (leftHand == false){
                leftHand = true;
                leftH = item;                
                System.out.println("左手に" +leftH+ "を持った！");

            } else {
                nimotsu++;
                backpack.add(item);
            }
        }

        void show(){
            if(rightHand) {
                System.out.println("右手には" +rightH+ "を持っている。");
            }else{
                System.out.println("まだ何も持っていない。");
            }
            if(leftHand) {
                System.out.println("左手には" +leftH+ "を持っている。");
            }
            nimotsu = backpack.size();
            if(nimotsu>0) {
                for (String s : backpack){
                    System.out.print(s +" ");
                }
                System.out.println("がカバンに入っている。");
            }
            System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
        }
    }
