# ImagePreview

多图预览

## 第三方包
[PhotoView](https://github.com/chrisbanes/PhotoView)

## 配置

在项目的build.gradle中,添加:

```groovy
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
在使用库的module中添加:
```groovy
	dependencies {
	    compile 'com.github.shucc:ImagePreview:v1.0'
	}
```

## 使用

初始化图片加载,推荐放在Application中:
```java
    ImageLoader.init(new ImageLoaderListener() {
        @Override
        public void load(Context context, PhotoView photoView, String imageUrl) {
            Glide.with(context)
                    .load(imageUrl)
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(photoView);
        }
    });
```
打开预览界面:
```java
    ImagePreViewActivity.launch(MainActivity.this, 0, ArrayList<String> imageList);
```