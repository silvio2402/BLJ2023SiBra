import { Grid } from "@mui/material";
import { useQuery } from "./util";
import { getRandomCatImage } from "./services/CatImageService";

function RandomCatList() {
  const { status, data, error } = useQuery({
    queryFn: () => getRandomCatImage(),
  });

  return (
    <Grid container>
      <Grid item xs={12}>
        {status === "pending" && <p>Loading...</p>}
        {status === "error" && <p>Error: {String(error)}</p>}
        {status === "success" && <img src={data} alt="Random cat" />}
      </Grid>
    </Grid>
  );
}

export default RandomCatList;
