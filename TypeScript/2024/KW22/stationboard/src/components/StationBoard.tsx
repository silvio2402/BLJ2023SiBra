import { useQuery } from "react-query";
import { queryStationboard } from "../lib/api";
import StationTable from "./StationTable";
import StationTitle from "./StationTitle";
import { Station } from "../lib/types";
import { useState } from "react";

function StationBoard() {
  const [selectedStation, setSelectedStation] = useState<Station>({
    id: "8503000",
    name: "Zürich HB",
    coordinate: { type: "WGS84", x: 47.378177, y: 8.540192 },
  });

  const { error, data } = useQuery(
    ["stationBoard", selectedStation?.id],
    () => queryStationboard(selectedStation.id!),
    {
      refetchInterval: 10000,
      enabled: !!selectedStation?.id,
    }
  );

  const stationboard = data?.stationboard;

  return (
    <div>
      <StationTitle
        selectedStation={selectedStation}
        setSelectedStation={setSelectedStation}
      />

      {!!error && <p>Error: {String(error)}</p>}
      {stationboard && <StationTable stationboard={stationboard} />}
    </div>
  );
}

export default StationBoard;
