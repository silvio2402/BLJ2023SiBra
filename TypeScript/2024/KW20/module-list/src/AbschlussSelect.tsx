import { useQuery } from "@tanstack/react-query";
import { getAllAbschlusses, useToken } from "./api";
import { MenuItem, Select } from "@mui/material";

interface AbschlussSelectProps {
  selectedAbschluss: string | undefined;
  setSelectedAbschluss: (abschluss: string | undefined) => void;
}

function AbschlussSelect({
  selectedAbschluss,
  setSelectedAbschluss,
}: AbschlussSelectProps) {
  const token = useToken();

  const { data: abschlusses, isPending } = useQuery({
    queryKey: ["abschlusses"],
    queryFn: () => getAllAbschlusses(token!),
    enabled: !!token,
  });

  return (
    <Select
      disabled={isPending}
      value={selectedAbschluss}
      onChange={(event) => setSelectedAbschluss(event.target.value)}
      sx={{ width: "100%", mb: 2 }}
    >
      <MenuItem value={undefined}>Alle Abschlüsse</MenuItem>
      {abschlusses?.map((abschluss) => (
        <MenuItem
          key={abschluss.beembk_abschlussid}
          value={abschluss.beembk_abschlussid}
        >
          {abschluss.beembk_abschlussname}
        </MenuItem>
      ))}
    </Select>
  );
}

export default AbschlussSelect;
