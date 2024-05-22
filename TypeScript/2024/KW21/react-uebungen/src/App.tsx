import { AppBar, Box, Container } from "@mui/material";
import "./App.css";
import RandomCatForm from "./RandomCatForm";
import RandomCatList from "./RandomCatList";

function App() {
  return (
    <Box p={2}>
      <Container>
        <AppBar />
        <RandomCatForm />
        <RandomCatList />
      </Container>
    </Box>
  );
}

export default App;
