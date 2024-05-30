import { QueryClient, QueryClientProvider } from "react-query";
import "./App.css";
import StationBoard from "./components/StationBoard";

const queryClient = new QueryClient();

function App() {
  return (
    <QueryClientProvider client={queryClient}>
      <StationBoard />
    </QueryClientProvider>
  );
}

export default App;
