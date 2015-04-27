## android-player
Animations when entering actvity or fragment made easy.

#### You have created beautiful UI , but it is boring

![svg](https://github.com/geftimov/android-pathview/blob/master/art/settings.gif) 

#### Run the player and you will can create beautiful transitions for your views.

```java
    final Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(length / 4f, 0.0f);
        path.lineTo(length, height / 2.0f);
        path.lineTo(length / 4f, height);
        path.lineTo(0.0f, height);
	    path.lineTo(length * 3f / 4f, height / 2f);
	    path.lineTo(0.0f, 0.0f);
	    path.close();
```

#### Result

![svg](https://github.com/geftimov/android-pathview/blob/master/art/settings.gif)

#### Costumization

To make custom Action , just extend the BaseAction and implement the two abstract methods.

```java
    void init(final View view);

    void animate(final View view);
```

#### Contributors

[Martin Vitanov](https://github.com/martinVitanov "Martin Vitanov") <br />
[Georgi Eftimov](https://github.com/geftimov "Georgi Eftimov")

##### Download

	dependencies {
		compile 'com.eftimoff:android-player:1.0.0@aar'
	}

##### Make your animations how ever you want	
	
![svg](https://github.com/geftimov/android-pathview/blob/master/art/settings.gif)![svg](https://github.com/geftimov/android-pathview/blob/master/art/settings.gif)![svg](https://github.com/geftimov/android-pathview/blob/master/art/settings.gif)


## Licence

    Copyright 2015 Georgi Eftimov

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
