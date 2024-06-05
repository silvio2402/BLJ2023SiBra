import { Box, Typography, Container } from "@mui/material";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import ModuleList from "./ModuleList";
import { TokenProvider } from "./api";
import "./App.css";
import AbschlussSelect from "./AbschlussSelect";
import { useState } from "react";

const queryClient = new QueryClient();

function AppQueryClientProvider({ children }: { children: React.ReactNode }) {
  return (
    <QueryClientProvider client={queryClient}>{children}</QueryClientProvider>
  );
}

function App() {
  const [selectedAbschluss, setSelectedAbschluss] = useState<
    string | undefined
  >(undefined);

  return (
    <AppQueryClientProvider>
      <TokenProvider>
        <Container maxWidth="sm" sx={{ py: 4 }}>
          <Box>
            <Typography variant="h4" component="h1" gutterBottom>
              Top TBZ Module
            </Typography>
          </Box>
          <Box>
            <AbschlussSelect
              selectedAbschluss={selectedAbschluss}
              setSelectedAbschluss={setSelectedAbschluss}
            />
          </Box>
          <Box>
            <ModuleList selectedAbschluss={selectedAbschluss} />
          </Box>
        </Container>
      </TokenProvider>
    </AppQueryClientProvider>
  );
}

export default App;
