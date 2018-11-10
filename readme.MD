## BiTriangleRotateStepView

### Usage

#### In app/build.gradle
```
    compile project(":bitrianglesteprotateview")
```

#### In MainActivity

```
    val view : BiTriangleRotateStepView = BiTriangleRotateStepView.create(this)
```

#### Adding AnimationListener in a view

```
     view.addOnAnimationListener({createToast("animation number $it is complete")}, {createToast("animation number $it is reset")})
```

### Demo

<img src="https://github.com/Anwesh43/LinkedBiTriangleStepView/blob/master/demo/bitrianglerotatestepview.gif" width="300px" height="500px">