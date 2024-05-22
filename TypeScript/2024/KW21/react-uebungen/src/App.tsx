import { AppBar, Box, Container, Grid } from "@mui/material";
import "./App.css";

function App() {
  return (
    <Box p={2}>
      <Container>
        <AppBar />
        <Grid container>
          <Grid item xs={12}>
            Form Here
          </Grid>
        </Grid>
        <Grid container>
          <Grid item xs={12}>
            List Here
          </Grid>
        </Grid>
      </Container>
    </Box>
  );
}

export default App;
