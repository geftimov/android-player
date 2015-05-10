## android-player
Animations when entering Actvity or Fragment made easy.</br>
Backward compatibility API 1.

#### You have created beautiful UI , but it is boring

![svg](https://github.com/geftimov/android-player/blob/master/art/playerPhoto.png) 

###### Run the player and you will can create beautiful transitions </br>for your views when entering Activity / Fragment.</br>Put in your onCreate() for Activity or onViewCreated() for Fragment.

```java
Player.init().
	animate(headerAction).
	then().
	animate(fabAction).
	then().
	animate(bottomAction).
	play();
```

#### Result

![svg](https://github.com/geftimov/android-player/blob/master/art/sample_one.gif)

#### Actions

```java
	final PropertyAction fabAction = PropertyAction.newPropertyAction(activityMainPinkFab).
			scaleX(0).
			scaleY(0).
			duration(750).
			interpolator(new AccelerateDecelerateInterpolator()).
			build();
	final PropertyAction headerAction = PropertyAction.newPropertyAction(activityMainheaderLayout).
			interpolator(new DecelerateInterpolator()).
			translationY(-200).
			duration(550).
			alpha(0.4f).
			build();
	final PropertyAction bottomAction = PropertyAction.newPropertyAction(activityMainMobileNumberLayout).
			translationY(500).
			duration(550).
			alpha(0f).
			build();
```

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
		compile 'com.eftimoff:androidplayer:1.0.2@aar'
	}

##### Make your animations how ever you want	
	
![svg](https://github.com/geftimov/android-player/blob/master/art/sample_two.gif) ![svg](https://github.com/geftimov/android-player/blob/master/art/sample_three.gif) ![svg](https://github.com/geftimov/android-player/blob/master/art/sample_four.gif)


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
