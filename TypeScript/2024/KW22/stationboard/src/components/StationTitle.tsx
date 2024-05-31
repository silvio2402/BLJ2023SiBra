import { Station } from "../lib/types";
import StationSelector from "./StationSelector";
import "./StationTitle.css";

interface StationTitleProps {
  selectedStation: Station | null;
  setSelectedStation: (station: Station) => void;
}

function StationTitle({
  selectedStation,
  setSelectedStation,
}: StationTitleProps) {
  return (
    <div className="station-title-container">
      <h1 className="station-title">{selectedStation?.name}</h1>
      <StationSelector selectStation={setSelectedStation} />
    </div>
  );
}

export default StationTitle;
