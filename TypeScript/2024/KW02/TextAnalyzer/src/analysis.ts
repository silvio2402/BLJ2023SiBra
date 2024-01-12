interface TextAnalysis {
  date: Date;
  filename: string;
  uniqueCount: number;
  totalCount: number;
  mostCommon: string;
  wordCounts: Record<string, number>;
}

export async function analyze(filename: string): Promise<TextAnalysis> {
  const analysisDate = new Date();

  const text = await Bun.file(filename).text();

  const words = text.split("\n").flatMap((line) => {
    line = line.trim().replace(/[^ \p{Letter}0-9]+/gu, "");
    return line.split(" ").flatMap((w) => {
      w = w.trim();
      if (w.length <= 0) return [];
      return w;
    });
  });

  const totalCount = words.length;

  const wordCounts = words.reduce<Record<string, number>>(
    (wordCounts, word) => {
      word = word.toLowerCase();
      if (wordCounts[word]) wordCounts[word] += 1;
      else wordCounts[word] = 1;

      return wordCounts;
    },
    {}
  );

  const uniqueCount = Object.keys(wordCounts).length;

  const mostCommon = Object.entries(wordCounts).reduce<[string, number]>(
    (mostCommon, current) => {
      if (current[1] > mostCommon[1]) mostCommon = current;
      return mostCommon;
    },
    ["", -1]
  )[0];

  return {
    date: analysisDate,
    filename,
    uniqueCount,
    totalCount,
    wordCounts,
    mostCommon,
  };
}

export function composeOutput(analysis: TextAnalysis) {
  let output = "";

  output += `${analysis.date.toLocaleString()} ${analysis.filename}\n`;
  output += `${"-".repeat(20)}\n`;
  output += `Number of unique words:\t${analysis.uniqueCount}\n`;
  output += `Total number of words:\t${analysis.totalCount}\n`;
  output += `Most common word:\t${analysis.mostCommon}\n`;
  output += `${"-".repeat(20)}\n`;

  Object.entries(analysis.wordCounts);
  const entries = Object.entries(analysis.wordCounts).sort(
    ([, a], [, b]) => b - a
  );

  for (let i = 0; i < entries.length && i < 10; i++) {
    const [word, count] = entries[i];
    output += `${word}\t${count}\n`;
  }

  return output;
}
