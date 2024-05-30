import { useQuery } from "react-query";
import { queryStationboard } from "../lib/api";
import StationTable from "./StationTable";
import StationTitle from "./StationTitle";

function StationBoard() {
  const { isLoading, error, data } = useQuery("stationBoard", () =>
    queryStationboard("8503000")
  );

  const station = data?.station;
  const stationboard = data?.stationboard;

  return (
    <div>
      {isLoading && <p>Loading...</p>}
      {!!error && <p>Error: {String(error)}</p>}
      {station?.name && <StationTitle stationName={station.name} />}
      {stationboard && <StationTable stationboard={stationboard} />}
    </div>
  );
}

export default StationBoard;
