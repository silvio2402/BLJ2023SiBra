import DepartureRow from "./DepartureRow";
import "./StationTable.css";
import type { StationboardItem } from "../lib/types";

interface StationTableProps {
  stationboard: StationboardItem[];
}

function StationTable({ stationboard }: StationTableProps) {
  return (
    <table className="station-table">
      <tbody>
        {stationboard.map((item) => (
          <DepartureRow key={item.name} stationboardItem={item} />
        ))}
      </tbody>
    </table>
  );
}

export default StationTable;
