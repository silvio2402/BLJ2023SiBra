import type { StationboardItem } from "../lib/types";

interface DepartureRowProps {
  stationboardItem: StationboardItem;
}

function DepartureRow({ stationboardItem }: DepartureRowProps) {
  const dateFormatter = new Intl.DateTimeFormat("de-CH", {
    hour: "2-digit",
    minute: "2-digit",
  });

  return (
    <tr>
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
    </tr>
  );
}

export default DepartureRow;
