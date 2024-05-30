import DepartureRow from "./DepartureRow";
import type { StationboardItem } from "../lib/types";

interface StationTableProps {
  stationboard: StationboardItem[];
}

function StationTable({ stationboard }: StationTableProps) {
  return (
    <div>
      <table>
        <thead>
          <tr>
            <th>Departure</th>
            <th>Line</th>
            <th>To</th>
          </tr>
        </thead>
        <tbody>
          {stationboard.map((item) => (
            <DepartureRow key={item.stop.departure} stationboardItem={item} />
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default StationTable;
