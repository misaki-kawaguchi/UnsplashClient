# UnsplashClient

## Presentationレイヤー
UI関連の処理を担当する。

それぞれの画面が以下の3つのUI関連クラスを持つ。

- View(Compose)
- ViewModel
- StateHolder


## Domainレイヤー
アプリが提供する本質的価値を定義する。


## Dataレイヤー
SPやDB、WebAPIなどアプリ外部のデータとのインターフェースの役割を果たす。

## Clean Architectureとは
依存関係の方向の制御とコードの細分化によって、機能追加や修正に強いアプリを作れるアーキテクチャ。

- 依存関係の方向の制御
不変的なアプリの本質的な価値を定義しているDomainレイヤーを依存関係の最上位に持ってくることで仕様変更によるコードの変更が少ないコードベースを作る。

- コードの細分化
機能や関心によってクラスを細かく分割し、適切なパッケージ配置をすることで、機能追加による影響範囲を限定的にすると共に、可読性の高いコードベースを作る。

## 制作フロー
1.Dataレイヤー作成

1.1 画像検索HTTP通信・インターフェース作成

- DTOの作成
- Retrofitサービス作成
- Repository作成

1.2 画像詳細情報取得HTTP通信・インターフェース作成
- DTOの作成
 - Data Transfer Object
   データの受け渡しのみ使用するオブジェクト
   JSON TO Kotlin Classをインストールする
- Retrofit関数追加
- Repository作成

2.Domainレイヤーの作成

2.1 モデル作成
- Photoモデル
- PhotoDetailモデル

2.2 画像検索UseCase作成
- 検索ワードを受け取り、検索結果が返す機能

2.3 画像詳細情報取得UseCase作成
- 画像IDを受け取り、画像詳細情報を返す機能

3.Presentationレイヤーの作成

3.1 画面遷移をセットアップ

- 画像検索画面
- 画像詳細表示画面

3.2 画像検索画面の作成

- State
- ViewModel
- View
  
3.3 画像詳細表示の作成
- State
- ViewModel
- View
