import { analyze, composeOutput } from "./analysis";
import path from "path";

if (Bun.argv.length < 3) {
  console.error("Please provide one argument consisting of the path.");
  process.exit(1);
}

const filename = path.resolve(Bun.argv[Bun.argv.length - 1]);

// Analyze
const analysis = await analyze(filename);

// Output
const output = composeOutput(analysis);
console.log(output);
// Write it to a file
const outputFilename = path.join(
  path.dirname(filename),
  `${path.basename(filename, path.extname(filename))}_evaluation.txt`
);
Bun.write(outputFilename, output);
