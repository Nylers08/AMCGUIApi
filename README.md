# Введение

Небольшой плагин, который централизует все меню на сервере. Он также предоставляет классы и интерфейсы, для быстрого создания меню и анимированных меню, в ваших плагинах.

Плагин писал исключительно для себя и своего сервера "AriolMC". Если есть желание, можете пользоваться абослютно бесплатно!

Кому-то не понравиться, что здесь *слишком много классов*, кому-то что архитектура не идеальна, или что где-то нарушены принципы CleanCode или SOLID(Я старался писать по ним, но это мой первый раз:D).
Но получилось, что получилось)

# Подключение

## maven

Для начала подключите jitpack
```xml
    <repositories>
        ...

        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
```

Затем подключите сам плагин
```xml
    <dependencies>
        ...

        <dependency>
            <groupId>com.github.Nylers08</groupId>
            <artifactId>AMCGUIApi</artifactId>
            <version>v1.0.0(УКАЖИТЕ НЕОБХОДИМУЮ ВЕРСИЮ)</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>
```

## gradle

Я не проверял, как работает на gradle.. Но подключаться должно так)

Подключение jitpack
```gradle
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```

Подключение самого плагина
```gradle
	dependencies {
	        implementation 'com.github.Nylers08:AMCGUIApi:v1.0.0(УКАЖИТЕ НЕОБХОДИМУЮ ВЕРСИЮ)'
	}
```

# Как пользоваться плагином

Прямо в проекте, сразу же лежит [docs.md](https://github.com/Nylers08/AMCGUIApi/blob/master/docs.md).
Там вкратце описано, как работает плагин, и как создавать своё меню. Почитайте, если решили пользоваться AMCGUIApi)
