import type { StationboardItem } from "../lib/types";
import "./DepartureRow.css";

interface DepartureRowProps {
  stationboardItem: StationboardItem;
}

function DepartureRow({ stationboardItem }: DepartureRowProps) {
  const dateFormatter = new Intl.DateTimeFormat("de-CH", {
    hour: "2-digit",
    minute: "2-digit",
  });

  return (
    <tr className="departure-row">
      <td>
        {dateFormatter.format(new Date(stationboardItem.stop.departure!))}
      </td>
      <td>
        {stationboardItem.category}
        {stationboardItem.number !== stationboardItem.name
          ? stationboardItem.number
          : null}
      </td>
      <td>{stationboardItem.to}</td>
      <td>Platform {stationboardItem.stop.platform}</td>
      <td>
        {stationboardItem.stop.delay
          ? `+${stationboardItem.stop.delay} min`
          : null}
      </td>
    </tr>
  );
}

export default DepartureRow;
