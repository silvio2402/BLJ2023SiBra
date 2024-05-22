import { api } from "./Api";

export async function getRandomCatImage() {
  const response = await api.get("/");
  const imageUrl = response["data"][0]["url"];
  console.log(imageUrl);

  return imageUrl;
}
