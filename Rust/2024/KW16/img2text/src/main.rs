use image::{io::Reader as ImageReader, DynamicImage, GenericImageView, Luma};

fn load_sample() -> DynamicImage {
    let img = ImageReader::open("image2.png").unwrap().decode().unwrap();
    return img;
}

fn rect_average(
    img: &dyn GenericImageView<Pixel = Luma<u8>>,
    x: u32,
    y: u32,
    w: u32,
    h: u32,
) -> f32 {
    let mut sum: u32 = 0;
    let mut count: u32 = 0;

    for i in x..x + w {
        for j in y..y + h {
            if !img.in_bounds(i, j) {
                continue;
            }
            let pixel = img.get_pixel(i, j);
            sum += pixel[0] as u32;
            count += 1;
        }
    }

    let avg = sum as f32 / count as f32;

    return avg;
}

const ASCII_TABLE: [char; 92] = [
    ' ', '`', '.', '-', '\'', ':', '_', ',', '^', '=', ';', '>', '<', '+', '!', 'r', 'c', '*', '/',
    'z', '?', 's', 'L', 'T', 'v', ')', 'J', '7', '(', '|', 'F', 'i', '{', 'C', '}', 'f', 'I', '3',
    '1', 't', 'l', 'u', '[', 'n', 'e', 'o', 'Z', '5', 'Y', 'x', 'j', 'y', 'a', ']', '2', 'E', 'S',
    'w', 'q', 'k', 'P', '6', 'h', '9', 'd', '4', 'V', 'p', 'O', 'G', 'b', 'U', 'A', 'K', 'X', 'H',
    'm', '8', 'R', 'D', '#', '$', 'B', 'g', '0', 'M', 'N', 'W', 'Q', '%', '&', '@',
];
const DARKNESS_TABLE: [f32; 92] = [
    0.0, 0.0751, 0.0829, 0.0848, 0.1227, 0.1403, 0.1559, 0.185, 0.2183, 0.2417, 0.2571, 0.2852,
    0.2902, 0.2919, 0.3099, 0.3192, 0.3232, 0.3294, 0.3384, 0.3609, 0.3619, 0.3667, 0.3737, 0.3747,
    0.3838, 0.3921, 0.396, 0.3984, 0.3993, 0.4075, 0.4091, 0.4101, 0.42, 0.423, 0.4247, 0.4274,
    0.4293, 0.4328, 0.4382, 0.4385, 0.442, 0.4473, 0.4477, 0.4503, 0.4562, 0.458, 0.461, 0.4638,
    0.4667, 0.4686, 0.4693, 0.4703, 0.4833, 0.4881, 0.4944, 0.4953, 0.4992, 0.5509, 0.5567, 0.5569,
    0.5591, 0.5602, 0.5602, 0.565, 0.5776, 0.5777, 0.5818, 0.587, 0.5972, 0.5999, 0.6043, 0.6049,
    0.6093, 0.6099, 0.6465, 0.6561, 0.6595, 0.6631, 0.6714, 0.6759, 0.6809, 0.6816, 0.6925, 0.7039,
    0.7086, 0.7235, 0.7302, 0.7332, 0.7602, 0.7834, 0.8037, 0.9999,
];

fn find_char(darkness: f32) -> char {
    for i in 0..DARKNESS_TABLE.len() {
        let curr_darkness = DARKNESS_TABLE[i];
        if i == DARKNESS_TABLE.len() - 1 {
            return ASCII_TABLE[i];
        }
        if darkness > DARKNESS_TABLE[i + 1] {
            continue;
        }
        if (darkness - curr_darkness) <= (DARKNESS_TABLE[i + 1] - darkness) {
            return ASCII_TABLE[i];
        } else {
            return ASCII_TABLE[i + 1];
        }
    }

    panic!("No char found");
}

// fn get_char_darkness(c: char) -> f32 {
//     for i in 0..ASCII_TABLE.len() {
//         if ASCII_TABLE[i] == c {
//             return DARKNESS_TABLE[i];
//         }
//     }

//     panic!("No char found");
// }

fn main() {
    let target_width = 200;

    let img = load_sample();
    let img = img.to_luma8();
    let width = img.width();
    let height = img.height();

    let char_width = width / target_width;
    let char_height = char_width * 2;

    for j in 0..height / char_height {
        for i in 0..target_width {
            let avg = rect_average(
                &img,
                i * char_width,
                j * char_height,
                char_width,
                char_height,
            );
            let ascii = find_char(avg / 255.0);
            print!("{}", ascii);
        }
        println!();
    }
}
