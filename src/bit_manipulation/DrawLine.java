package bit_manipulation;

// A monochrome screen is stored as a single array of bytes,
// allowing eight consecutive pixels to be stored in one byte.
// The screen has width w, where w is divisible by 8
// (that is, no byte will be split across rows).
// The height of the screen, of course,
// can be derived from the length of the array and the width.
// Implement a function that draws a horizontal line from (x1, y) to (x2, y).
//
// The method signature should look something like:
// drawLine(byte[] screen, int width, int x1, int x2, int y)


public class DrawLine {
    public static void main(String[] args) {
        int width = 8;
        int height = 1;
        for (int r = 0; r < height; r++) {
            for (int c1 = 0; c1 < width; c1++) {
                for (int c2 = c1; c2 < width; c2++) {
                    byte[] screen = new byte[width * height / 8];

                    System.out.println("row: " + r + ": " + c1 + " -> " + c2);
                    drawHLine(screen, width, c1, c2, r);
                    printScreen(screen, width);
                    System.out.println("\n\n");
                }
            }
        }
    }

    public static void drawHLine(byte[] screen, int width, int x1, int x2, int y) {
        // width = 200, x1 = 65, x2 = 192, y = 8,
        int start_offset = x1 % 8;   // start_offset = 1
        int first_full_byte = x1 / 8; // first_full_byte = 8
        if (start_offset != 0) {
            first_full_byte++; // first_full_byte = 9
        }

        int end_offset = x2 % 8;   // end_offset = 0
        int last_full_byte = x2 / 8; // last_full_byte = 24
        if (end_offset != 7) {
            last_full_byte--;  // last_full_byte = 24
        }

        // Set full bytes
        for (int b = first_full_byte; b <= last_full_byte; b++) {
            screen[(width / 8) * y + b] = (byte) 0xFF;     // 209 - 210 - 211 ... 224
        }

        byte start_mask = (byte) (0xFF >> start_offset);  // start_mask = 0b01111111
        byte end_mask = (byte) ~(0xFF >> (end_offset + 1)); // end_mask = 0b10000000

        // Set start and end of line
        if ((x1 / 8) == (x2 / 8)) { // If x1 and x2 are in the same byte
            byte mask = (byte) (start_mask & end_mask);
            screen[(width / 8) * y + (x1 / 8)] |= mask;
        } else {
            if (start_offset != 0) {
                int byte_number = (width / 8) * y + first_full_byte - 1; // byte_number = 208
                screen[byte_number] |= start_mask;  // 208 -> 0b01111111
            }
            if (end_offset != 7) {
                int byte_number = (width / 8) * y + last_full_byte + 1;  // byte_number = 225
                screen[byte_number] |= end_mask;  // 225 -> 0b10000000
            }
        }
    }

    public static void printByte(byte b) {
        for (int i = 7; i >= 0; i--) {
            char c = ((b >> i) & 1) == 1 ? '1' : '_';
            System.out.print(c);
        }
    }

    public static void printScreen(byte[] screen, int width) {
        int height = screen.length * 8 / width;
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c += 8) {
                byte b = screen[computeByteNum(width, c, r)];
                printByte(b);
            }
            System.out.println();
        }
    }

    public static int computeByteNum(int width, int x, int y) {
        return (width * y + x) / 8;
    }
}
