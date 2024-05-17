import { Box, Typography, Container, useTheme } from "@mui/material";
import "./App.css";
import ModuleList from "./ModuleList";

function App() {
  return (
    <Container maxWidth="sm" sx={{ py: 4 }}>
      <Box>
        <Typography variant="h4" component="h1">
          Top TBZ Module
        </Typography>
      </Box>
      <Box>
        <ModuleList />
      </Box>
    </Container>
  );
}

export default App;
