import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class omatsuri {
         static int ikisaki;
    public static void main(String[] args) {
         System.out.println("今日はお祭りに来ました。");

        while(true) {
         System.out.println("「どのお店に行こうかな？」");
         // 屋台の提示とキーボード入力による選択
         System.out.println("行きたいお店の数字を選んで入力後Enter");
         System.out.println("1.たこやき 2.やきそば 3.りんご飴 4.射的 0.帰宅");
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
             ikisaki = Integer.parseInt(str);
         }
         catch (Exception e) {
            System.out.println("数字以外が入力されました。");
         }

         // switch文による屋台の分岐
         switch(ikisaki) {
            case 1:
                System.out.println("「たこ焼き屋さんに行こう！」");
                break;
            case 2:
                System.out.println("「やきそば屋さんに行こう！」");
                break;
            case 3:
                System.out.println("「りんご飴屋さんに行こう！」");
                break;
            case 4:
                System.out.println("「射的屋さんに行こう！」");
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