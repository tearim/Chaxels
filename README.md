# Chaxels

Chaxels (Character Pixels) is a terminal-based rendering engine for Java that uses a character-based abstraction to create layered, colored, and styled console output. It allows for the creation of complex terminal interfaces and animations by treating characters as pixels with properties like RGB color, background color, and Z-index.

## Features

- **Layered Rendering:** Support for multiple shapes and layers using Z-indexing.
- **Rich Styling:** Individual characters (Chaxels) can have their own foreground and background RGB colors.
- **Flexible Shapes:** Define complex shapes using `ChaxelString` and `Shape` objects.
- **Easy-to-use API:** Simplified methods for adding, moving, and removing shapes on a screen.

## Quick Start

```java
import com.zarterstein.chaxels.Screen;
import com.zarterstein.chaxels.clrender.Renderer;
import com.zarterstein.chaxels.Shape;

public class MyTerminalApp {
    public static void main(String[] args) {
        // Initialize the renderer and screen
        Renderer renderer = new Renderer();
        renderer.createScreen(80, 24);
        Screen screen = renderer.getScreen();

        // Create a simple shape (conceptually)
        // Shape myShape = ...; 
        
        // Add shape to screen
        // screen.add(myShape, "my_id", 10, 5);

        // Render the screen
        renderer.printScreen();
    }
}
```

## Design Notes & Considerations

The Chaxels library was built with specific architectural decisions that users should be aware of:

1.  **`ChaxelString` Inheritance:** `ChaxelString` extends `ArrayList<Chaxel>`. While this provides a wide range of collection operations, users should use them with care to maintain the intended structure and invariants of the string.
2.  **The "Black Hole" Pattern:** `ChaxelString.safeAt(int)` is designed to act as a "black hole". It returns a dummy Chaxel for out-of-bounds indices, allowing for easier copy and reading processes without the need for constant bounds checking or worrying about exceptions.
3.  **ANSI Parsing:** Currently, `Converter.toChaxels` does not implement TrueColor ANSI sequence parsing. Support for this may be added in future versions.
4.  **Rendering Performance:** The current rendering implementation in `Screen.write()` requires full canvas copies. While this is not critical for typical terminal applications (e.g., 80x25 screens with a few layers), it may be optimized in future releases for high-performance requirements.

## Credits

- **Core Code:** Human-written.
- **Documentation & README:** Created using LLM assistance.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
